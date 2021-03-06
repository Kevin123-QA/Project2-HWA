'use strict'

const amount = document.querySelector("#amount");
const type = document.querySelector("#typeSelector");
const info = document.querySelector("#additional");
const modal = document.querySelector("#exampleModal");
const EditAmount = document.querySelector("#EditAmount");
const EditType = document.querySelector("#EditTypeSelector");
const EditInfo = document.querySelector("#EditAdditional");
const EditSave = document.querySelector("#EditSave");
let Message = document.querySelector("#div1");




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
                       ViewAll(spending_tracker)
        }

    })
    .catch((err) => {
        console.log(err);
    });

function ViewAll(spending_tracker) {
    // const decimal = spending_tracker.amount.toFixed(2);
    // console.log(decimal)

    let table = document.querySelector("table");



    function addRows(table, spending_tracker) {
        let row = table.insertRow();

        for (let key in spending_tracker) {

            let tabledata = document.createElement("td");
            let text = document.createTextNode(spending_tracker[key]);
            tabledata.appendChild(text);
            row.appendChild(tabledata);
        }
        let tableEdit = document.createElement("td");
        row.appendChild(tableEdit);

        let edit = document.createElement("button");

        edit.innerHTML = "Edit";
        edit.className = "btn btn-warning";
        edit.setAttribute("data-toggle", "modal");
        edit.setAttribute("data-target", "#EditModal");
        edit.setAttribute("id","editBTN");
        tableEdit.appendChild(edit);

        edit.onclick = () => {
            getData(spending_tracker)
            EditSave.addEventListener("click", () => { update(spending_tracker.id) })
        };

        let tableDel = document.createElement("td");
        row.appendChild(tableDel);

        let remove = document.createElement("button");
        remove.innerHTML = "Delete";
        remove.setAttribute("id","removeBTN");
        remove.className = "btn btn-danger";
        remove.onclick = () => {
            Delete(spending_tracker.id)
        };

        tableDel.appendChild(remove);
         }
    addRows(table, spending_tracker);
}



 const add = () => {
    const TYPE = type.value;
    const AMOUNT= amount.value;
    const INFO = info.value;
    console.log(`${TYPE} ${AMOUNT} ${INFO}`)
    let Heading = document.createElement('h5');
    let addMessage = document.createTextNode("Entry Has Been Added");
    Heading.appendChild(addMessage);
    Message.appendChild(Heading);
    
    let newObj = {
        type: TYPE,
        info: INFO,
        amount: AMOUNT
    };

    axios
        .post(`${url}/create`, newObj)
        .then((resp) => {
            console.log(resp);
            console.log("Start timeout")
            setTimeout(()=>{window.location.reload();},3000)
             
         })
                 
       
        .catch((err) => {
             console.log(err)
        });
            
 
        
}

const Delete = (spending_tracker) => {
    let Heading = document.createElement('h5');
    let deleteMessage = document.createTextNode("Entry Has Been Deleted");
    Heading.appendChild(deleteMessage);
    Message.appendChild(Heading);
    
    console.log(spending_tracker)
    
    axios
        .delete(`${url}/delete/` + spending_tracker)

        .then((resp) => {
            
            console.log(resp);
            setTimeout(()=>{window.location.reload();},3000)
        })
        .catch((err) => console.log.err);

}

const reset = () => {
    info.value = "";
    amount.value = "";
    let dropDown = document.getElementById("typeSelector");
    dropDown.selectedIndex = "";
}

const resetModal = () => {
    EditInfo.value = "";
    EditAmount.value = "";
    let dropDown = document.getElementById("EditTypeSelector");
    dropDown.selectedIndex = "";
}


const update = (spending_tracker) => {
    const EDITTYPE = EditType.value
    const EDITINFO = EditInfo.value
    const EDITAMOUNT = EditAmount.value
    let Heading = document.createElement('h5');
    let deleteMessage = document.createTextNode("Entry Has Been Updated");
    Heading.appendChild(deleteMessage);
    Message.appendChild(Heading);

    console.log(`${EDITTYPE} ${EDITAMOUNT} ${EDITINFO}`)

    let editObj = {
        type: EDITTYPE,
        info: EDITINFO,
        amount: EDITAMOUNT
    };

    axios
        .put(`${url}/update/` + spending_tracker, editObj)
        .then((resp) => {
            console.log(resp)
                       
        })
        .then((resp) => {
            console.log(resp)
            setTimeout(()=>{window.location.reload();},3000)
            
        })
        .catch((err) => console.log.err);

}


const getData = (spending_tracker) => {

    EditAmount.value = spending_tracker.amount;
    EditInfo.value = spending_tracker.info;
    let EditDropDown = document.getElementById("EditTypeSelector")
    if (spending_tracker.type == "Payments") {
        EditDropDown.selectedIndex = 1;
    }
    else if (spending_tracker.type == "Eating Out") {
        EditDropDown.selectedIndex = 2;
    }
    else if (spending_tracker.type == "Groceries") {
        EditDropDown.selectedIndex = 3;
    }
    else if (spending_tracker.type == "Entertainment") {
        EditDropDown.selectedIndex = 4;
    }
    else if (spending_tracker.type == "Shopping") {
        EditDropDown.selectedIndex = 5;
    }
    else if (spending_tracker.type == "Bills") {
        EditDropDown.selectedIndex = 6;
    }
    else if (spending_tracker.type == "Other") {
        EditDropDown.selectedIndex = 7;
    }


}






