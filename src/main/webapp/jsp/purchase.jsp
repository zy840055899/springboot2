<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/26
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>purchase</title>
</head>
<script type="application/javascript" src="../script/jquery-3.4.0.min.js"></script>
<script type="application/javascript">
    $(function () {
        // 买伍万次，库存只有30000
        for (var i = 0; i < 2000; i++) {
            var param = {
                userId: 1,
                productId: 1,
                quantity: 1
            };
            // 异步请求，模拟多人抢购
            $.post("./purchase", param, function (result) {
                // alert(result);
            });
        }

    });
</script>
<body>
<h3>购买商品</h3>

</body>
</html>
