import $ from "jquery";

function sendLanguage() {


    let selectedLang = document.getElementById('langSelect').options[document.getElementById('langSelect').selectedIndex].value
    let promise = new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest()
        xhr.open('GET', "http://localhost:8080/main")
        xhr.setRequestHeader('Accept-Language', selectedLang)
        // xhr.responseType = 'json'
        xhr.onload = () => {
            resolve(xhr.response)
        }

        xhr.send()
    })
    promise.then(data => {
        console.log(data)
        document.getElementById("textLabel").innerHTML = data
    })
}
