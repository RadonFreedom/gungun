function getResult() {

    $.ajax({
        type: "POST",
        url: "/result",
        data: {
            a1: $("#a1").is(":checked"),
            a2: $("#a2").is(":checked"),
            a3: $("#a3").is(":checked"),
            b1: $("#b1").is(":checked"),
            b2: $("#b2").is(":checked"),
            b3: $("#b3").is(":checked"),
            c1: $("#c1").is(":checked"),
            c2: $("#c2").is(":checked"),
            c3: $("#c3").is(":checked"),
            c4: $("#c4").is(":checked"),
            c5: $("#c5").is(":checked"),
            d1: $("#d1").val(),
            d2: $("#d2").val(),
            d3: $("#d3").is(":checked"),
            d4: $("#d4").is(":checked"),
            e1: $("#e1").is(":checked"),
            e2: $("#e2").is(":checked"),
            e3: $("#e3").is(":checked"),
            e4: $("#e4").is(":checked"),
            e5: $("#e5").is(":checked"),
            e6: $("#e6").is(":checked"),
            e7: $("#e7").is(":checked"),
            e8: $("#e8").is(":checked"),
            e9: $("#e9").is(":checked"),
            e10: $("#e10").is(":checked"),
            e11: $("#e11").is(":checked"),
            e12: $("#e12").is(":checked"),
            e13: $("#e13").is(":checked"),
            location: $("#location").val()
        },
        success: function (result) {
            if (result.success == true) {
                layer.confirm("最适合你的职位是：" + result.data, {btn: ["确定"]},
                    function () {
                        layer.closeAll();
                    });
            } else {
                layer.confirm(result.msg, {btn: ["确定"]},
                    function () {
                        window.location.href="/settings.html";
                    });
            }
        },
        error: function () {
            layer.msg("请求有误");
        }
    });
}

function setSetting() {

    $.ajax({
        type: "POST",
        url: "/setting",
        data: {
            setting: $("#setting").val()
        },
        success: function (result) {
            if (result.success == true) {
                layer.confirm("设置成功！", {btn: ["确定"]},
                    function () {
                        window.location.href="/";
                    });
            } else {
                layer.confirm(result.msg, {btn: ["确定"]},
                    function () {
                        window.location.href="/settings.html";
                    });
            }
        },
        error: function () {
            layer.msg("请求有误");
        }
    });
}