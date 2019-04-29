jQuery(document).ready(function() {
		var contextPath = $( "#contextPath" ).html();
        $("#list").jqGrid({
                url : contextPath + "/loadData",
                datatype : "json",
                mtype : 'POST',
                colNames : [ 'Id', 'FirstName', 'LastName' ],
                colModel : [ {
                        name : 'id',
                        index : 'id',
                        width : 100
                }, {
                        name : 'firstName',
                        index : 'firstname',
                        width : 150,
                        editable : true
                }, {
                        name : 'lastName',
                        index : 'lastname',
                        width : 150,
                        editable : true
                }],
                pager : '#pager',
                rowNum : 10,
                rowList : [ 10, 20, 30 ],
                sortname : 'id',
                sortorder : 'desc',
                viewrecords : true,
                gridview : true,
                caption : 'User Details',
                jsonReader : {
                        repeatitems : false,
                },
                editurl : contextPath + "/loadData"
        });
        jQuery("#list").jqGrid('navGrid', '#pager', {
                edit : true,
                add : true,
                del : true,
                search : true
        });
});