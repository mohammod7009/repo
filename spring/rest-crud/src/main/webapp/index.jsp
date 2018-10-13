<!DOCTYPE html>
 
<html>
    <head>
        <title>RESTful CRUD</title>
        <meta charset="UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
		<h2>RESTful CRUD - Using Spring @RestController & jQuery</h2>
        <div>
            <div>
			<p>
			ID: <input type="text" name="id" id="id" value="1"> 
			Value: <input type="text" name="value" id="value" value="Something"> 
			<p>
			Response: <pre id="response" name="response"></pre> 
			<p>
            <button type="button" name="btnCreate" id="btnCreate" onclick="create();" >Create Pojo</button> 
            <button type="button" name="btnUpdate" id="btnUpdate" onclick="update();" >Update Pojo</button>
			<button type="button" name="btnPatchByID" id="btnPatchByID" onclick="patchByID();" >Patch Value By ID</button> 
			<p>
			<button type="button" name="btnGetAll" id="btnGetAll" onclick="getAll();" >Get All</button>  (<i>Ignores entered ID & Value</i>)
			<p>
			<button type="button" name="btnGetByID" id="btnGetByID" onclick="getByID();" >Get By ID</button> 
			<button type="button" name="btnDelete" id="btnDelete" onclick="deleteByID();" >Delete By ID</button> (<i>Ignores entered Value</i>)
			</div>	
        </div>
       
        <script type="text/javascript">

        function create() {
			resetDisplay();
            display("create...");
            $.ajax({
                type: "POST",
                url: "/pojos/",
                dataType: "json",
                contentType: 'application/json',
                success: function(value) {
                    display("success ");
                    display(value);
                },
                error: function(value) {
                    display("error: " + value.responseText + " status: " + value.status);
                },
                done: function(value) {
                    display("done " + value);
                },
                data: JSON.stringify({
                    id: $("#id").val(),
                    value: $("#value").val()
                })
            });

        }

        function getAll() {
			resetDisplay();
            display("getAll...");
            $.ajax({
                type: "GET",
                url: "/pojos/",
                dataType: "json",
                contentType: "application/json",
                success: function(value) {
                    display("success ");
                    for (var i = 0; i < value.length; i++) {
                        display(value[i]);
                    }
                },
                error: function(value) {
                    display("error: " + value.responseText + " status: " + value.status);
                },
                done: function(value) {
                    display("done " + value);
                }
            });
        }

        function getByID() {
			resetDisplay();
            display("getByID...");
            var id = $("#id").val();
            display(id);
            $.ajax({
                type: "GET",
                url: "/pojos/" + id,
                contextType: "application/json",
                dataType: "json",
                success: function(value) {
                    display("success ");
                    display(value);
                },
                error: function(value) {
                    display("error: " + value.responseText + " status: " + value.status);
                },
                done: function(value) {
                    display("done " + value);
                }
            });
        }

        function update() {
			resetDisplay();
            display("update...");
            $.ajax({
                type: "PUT",
                url: "/pojos/",
                contentType: "application/json",
                dataType: "json",
                success: function(value) {
                    display("success ");
                    display(value);
                },
                error: function(value) {
                    display("error: " + value.responseText + " status: " + value.status);
                },
                done: function(value) {
                    display("done " + value);
                },
                data: JSON.stringify({
					id: $("#id").val(),
                    value: $("#value").val()
                })
            });
        }

        function patchByID() {
			resetDisplay();
            display("patchByID...");
            var id = $("#id").val();
            $.ajax({
                type: "PATCH",
                url: "/pojos/" + id,
                contentType: "application/json",
                dataType: "json",
                success: function(value) {
                    display("success ");
                    display(value);
                },
                error: function(value) {
                    display("error: " + value.responseText + " status: " + value.status);
                },
                done: function(value) {
                    display("done " + value);
                },
                data: JSON.stringify({
                    value: $("#value").val()
                }),
            });
        }

        function deleteByID() {
			resetDisplay();
            display("deleteByID...");
            var id = $("#id").val();
            display(id);
            $.ajax({
                type: "DELETE",
                url: "/pojos/" + id,
                contextType: "application/json",
                dataType: "json",
                success: function(value) {
                    display("success ");
                    display(value);
                },
                error: function(value) {
                    display("error: " + value.responseText + " status: " + value.status);
                },
                done: function(value) {
                    display("done " + value);
                }
            });
        }
		
        function resetDisplay () {
			$("#response").html(""); 
		}
        function display (msg) {
			console.log(msg);
			$("#response").append("<br>"+JSON.stringify(msg)); 
		}
        </script>
       
    </body>
</html>