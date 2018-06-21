/**
 * 添加到购物车
 * @param skuId 销售单元Id
 */
function addTrolley(skuId) {
    $.ajax({
        url: "/trolley/addItem",
        data: $.param({"skuId": skuId, "amount": "1"}),
        type: "get",
        dataType: "json",
        success: function (responseData) {
            if (responseData.status == "-1") {
                console.log("失败");
                console.log(responseData.data);
                return;
            }
            $("#trolley").load("/trolley/toSimpleList");
            $('#mess').text(responseData.data);
            $('#messModal').modal('show');
        },
        error: function () {
            console.log("失败");
        }
    });
}


/**
 * 添加到商品对比列表
 * @param skuId 销售单元Id
 */
function addComparisonTable(skuId) {
    $.ajax({
        url: "/comparison/getListSize",
        data: $.param({}),
        type: "get",
        dataType: "json",
        success: function (responseData) {
            if (responseData.status == "-1") {
                console.log("失败");
                console.log(responseData.data);
                return;
            }
            //限定商品对比个数
            if (responseData.data >= 4) {
                location.href = "/comparison/toList";
                return;
            }
            $.ajax({
                url: "/comparison/addItem",
                data: $.param({"skuId": skuId}),
                type: "get",
                dataType: "json",
                success: function (responseData) {
                    if (responseData.status == "-1") {
                        console.log("失败");
                        console.log(responseData.data);
                        return;
                    }
                    $('#mess').text(responseData.data);
                    $('#messModal').modal('show');
                },
                error: function () {
                    console.log("失败");
                }
            });
        },
        error: function () {
            console.log("失败");
        }
    });
}

function addCollect(skuId, userId) {
    $.ajax({
        url: "/collect/addCollect",
        data: $.param({"skuId": skuId, "userId": userId}),
        type: "get",
        dataType: "json",
        success: function (responseData) {
            if (responseData.status == "-1") {
                console.log("失败");
                console.log(responseData.data);
                return;
            }
            $('#mess').text(responseData.data);
            $('#messModal').modal('show');
        },
        error: function (obj) {
            if (obj.status == 200) {
                location.href = "/login";
            }
            console.log("失败");
        }
    });
}