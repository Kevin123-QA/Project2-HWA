'use strict'

const amount = document.querySelector("#amount");
const type = document.querySelector("#typeSelector");
const info = document.querySelector("#additional");
const displayinfo = document.querySelector("#display");


const subButton = document.querySelector("#submit");
const url ="http://localhost:8080"


axios
    .get(`${url}/getAll`, {
        "headers":{
            "Access-Control-Allow-Origin": "*"
        }
    })
    .then((response)=>{
        console.log(response);
        for (let data of response.data){
            ViewAll(data)
        }

    })
    .catch((err)=>{
        console.log(err);
    });

const ViewAll = (information) => {
    let a =Array(information)
    const p = document.createElement("p");
    const text = document.createTextNode(`£${information.amount} ${information.type} ${information.info}`)
    p.appendChild(text);
    displayinfo.appendChild(p);
    let aJSON = JSON.stringify(a);
    console.log(a)
 }

const add=()=>{
    const TYPE = type.value;
    const AMOUNT = amount.value;
    const INFO = info.value;
    console.log(`${TYPE} ${AMOUNT} ${INFO}`)
    
    let newObj ={
        type:TYPE,
        info:INFO,
        amount: AMOUNT
    };

    axios
        .post(`${url}/create`,newObj)
        .then((resp) => {
            console.log(resp);
            alert("Entry Has been Added");
           window.location.reload();
        } )
        .catch((err) => console.log(err));
}  

