AJS.$(function(){
    console.log("############### Option Creator for JIRA ###############")
    AJS.$("#select2-example").auiSelect2();
});

function openDialogOC(){
    AJS.dialog2("#oc-create").show();
}

function hideDialogOC(){
    AJS.dialog2("#oc-create").hide();
}