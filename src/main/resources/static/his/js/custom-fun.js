/**
 * 自定义方法
 * Copyright (c) 2024 SteveMMMy
 */

/**
 * 去除 $.table.selectDictLabel 函数返回值两边的 html 标签
 * @param html
 * @returns {string|string}
 */
function stripHtmlTagsDOMParser(html) {
    const parser = new DOMParser();
    const doc = parser.parseFromString(html, "text/html");
    return doc.body.textContent || doc.body.innerText || "";
}

/**
 * 请求数据并初始化 bootstrap-suggest 插件
 * @param url 后端请求 url，返回 json 数据
 * @param selector jQuery 选择器
 * @param successCallback 获取数据成功回调函数，用于修改数据
 * @param options bootstrap-suggest 选项
 * @param onSetSelectValueCallback bootstrap-suggest 选中后回调函数
 * @param onUnsetSelectValueCallback bootstrap-suggest 自由输入内容时触发
 */
function getDataAndInitBsSuggest(
    url, selector, successCallback, options, onSetSelectValueCallback, onUnsetSelectValueCallback
) {
    $.ajax({
        url: url,
        type: 'POST',
        dataType: 'json',
        success: function (response) {
            response = successCallback(response);

            $(selector).bsSuggest({
                data: {"value": response},
                getDataMethod: 'data',
                showHeader: true,
                effectiveFields: options.effectiveFields,
                effectiveFieldsAlias: options.effectiveFieldsAlias,
                idField: options.idField,
                keyField: options.keyField,
                ignorecase: options.ignorecase,
                autoDropup: options.autoDropup,
                hideOnSelect: options.hideOnSelect,
                showBtn: options.showBtn,
                clearable: options.clearable,
                inputWarnColor: typeof options.inputWarnColor !== 'undefined' ? options.inputWarnColor : 'rgba(255,0,0,.1)'
            }).on('onSetSelectValue', function (e, selectedData, selectedRawData) {
                onSetSelectValueCallback(e, selectedData, selectedRawData);
            }).on('onUnsetSelectValue', function () {
                onUnsetSelectValueCallback();
            });
        },
        error: function (xhr, status, error) {
            console.error('Error fetching data:', error);
        }
    });
}
