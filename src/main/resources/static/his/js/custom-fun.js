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
