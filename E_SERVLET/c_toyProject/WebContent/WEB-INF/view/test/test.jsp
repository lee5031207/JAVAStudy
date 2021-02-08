<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<head>
    <style>
        .node{
            border : 1px solid black;
            width: 300px;
            height: 100px;
        }
        #service{
            /* display: none; */
        }
    </style>
</head>
<body>
    <form action="${context}/test/post">
        <input type="text" name="service" id="service">
        <div class="node" id="node1">노드1</div>
        <div class="node" id="node2">노드2</div>
        <div class="node" id="node3">노드3</div>
        <div class="node" id="node4">노드4</div>
        <input type="submit" value="전송">
    </form>
    <script>
        document.querySelectorAll(".node").forEach((node)=>{
            node.addEventListener("click",(e)=>{
                console.log(e.target.id);
                document.querySelector("#service").value = e.target.id;
            })
        })
    </script>
</body>
</html>