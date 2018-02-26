
var hiragana = "[\u3041-\u3096ー]";

function setError(obj, value) {
    var classList = obj.classList;
    if(value){
        if(!classList.contains("error")){
            classList.add("error");
        }
    }else{
        if(classList.contains("error")){
            classList.remove("error");
        }
    }
    return value
}

function checkAuthor(){
    var obj = document.getElementsByName("author")[0];
    var divObj = document.getElementById("author");
    return !setError(divObj, obj.value == "" || obj.value.length > 16)
}

function checkBody0(){
    var inputObj = document.getElementsByName("body0")[0];
    var divObj = document.getElementById("kaminoku");
    var hiraganaRegex = new RegExp("^"+hiragana+"{5}$");
    return !setError(divObj, hiraganaRegex.exec(inputObj.value) == null);
}

function checkBody1(){
    var inputObj = document.getElementsByName("body1")[0];
    var divObj = document.getElementById("nakanoku");
    var hiraganaRegex = new RegExp("^"+hiragana+"{7}$");
    return !setError(divObj, hiraganaRegex.exec(inputObj.value) == null);
}

function checkBody2(){
    var inputObj = document.getElementsByName("body2")[0];
    var divObj = document.getElementById("shimonoku");
    var hiraganaRegex = new RegExp("^"+hiragana+"{5}$");
    return !setError(divObj, hiraganaRegex.exec(inputObj.value) == null);
}

function checkOnSubmit(){
    return checkAuthor() && checkBody0() && checkBody1() && checkBody2();
}
