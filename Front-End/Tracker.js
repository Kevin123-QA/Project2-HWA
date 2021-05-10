'use strict'

const amount = document.querySelector("#amount");
const type = document.querySelector("#typeSelector");
const info = document.querySelector("#additional");




const subButton = document.querySelector("#submit");
const url = "http://localhost:8080"


axios
    .get(`${url}/getAll`, {
        "headers": {
            "Access-Control-Allow-Origin": "*"
        }
    })
    .then((response) => {

        console.log(response);
        for (let spending_tracker of response.data) {
            //console.log(spending_tracker.id)
            ViewAll(spending_tracker)
        }

    })
    .catch((err) => {
        console.log(err);
    });

function ViewAll(spending_tracker) {
    //console.log(typeof spending_tracker)
    //console.log(spending_tracker.id)

    let table = document.querySelector("table");



    function addRows(table, spending_tracker) {
        let row = table.insertRow();

        for (let key in spending_tracker) {

            let tabledata = document.createElement("td");
            let text = document.createTextNode(spending_tracker[key]);
            tabledata.appendChild(text);
            row.appendChild(tabledata);
        }

        //console.log(spending_tracker.id)

        let tableEdit = document.createElement("td");
        row.appendChild(tableEdit);

        let edit = document.createElement("button");
        edit.id = "editModal"
        edit.innerHTML = "Edit";
        edit.className = "btn btn-warning"
        edit.toggle = "modal";
        edit.onclick = "update()";
        edit.target="#exampleModal"
        tableEdit.appendChild(edit);


        let tableDel = document.createElement("td");
        row.appendChild(tableDel);

        let remove = document.createElement("button");
        remove.innerHTML = "Delete";
        remove.className = "btn btn-danger";
        remove.onclick = ()=>{
                Delete(spending_tracker.id)
        };
        
        tableDel.appendChild(remove);

    }
    addRows(table, spending_tracker);
}



const add = () => {
    const TYPE = type.value;
    const AMOUNT = amount.value;
    const INFO = info.value;
    console.log(`${TYPE} ${AMOUNT} ${INFO}`)

    let newObj = {
        type: TYPE,
        info: INFO,
        amount: AMOUNT
    };

    axios
        .post(`${url}/create`, newObj)
        .then((resp) => {
            console.log(resp);
            alert("Entry Has been Added");
            window.location.reload();
        })
        .catch((err) => console.log(err));
}

const Delete = (spending_tracker) => {

    // let id = spending_tracker
    // console.log(this.id)
    axios
        .delete(`${url}/delete/` + spending_tracker)

        .then((resp) => {
            // this.spending_tracker.id
            // console.log(this.spending_tracker.id)
            console.log(resp);
            window.location.reload();
        })
    .catch((err) => console.log.err);

}
const reset = () => {
    info.value = "";
    amount.value = "";
    var dropDown = document.getElementById("typeSelector");
    dropDown.selectedIndex = "";
}

const update = () => {


}













