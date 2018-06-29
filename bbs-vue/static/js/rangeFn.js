// 获取光标位置
function getCursortPosition(textDom) {
    var cursorPos = 0;
    if (document.selection) {
        // IE Support
        textDom.focus();
        var selectRange = document.selection.createRange();
        selectRange.moveStart('character', -textDom.value.length);
        cursorPos = selectRange.text.length;
    } else if (textDom.selectionStart || textDom.selectionStart == '0') {
        // Firefox support
        cursorPos = textDom.selectionStart;
    }
    return cursorPos;
}

// 设置光标位置
function setCaretPosition(textDom, pos) {
    if (textDom.setSelectionRange) {
        // IE Support
        textDom.focus();
        textDom.setSelectionRange(pos, pos);
    } else if (textDom.createTextRange) {
        // Firefox support
        var range = textDom.createTextRange();
        range.collapse(true);
        range.moveEnd('character', pos);
        range.moveStart('character', pos);
        range.select();
    }
}
// 获取选中文字
function getSelectText() {
    var userSelection, text;
    if (window.getSelection) {
        // Firefox support
        userSelection = window.getSelection();
    } else if (document.selection) {
        // IE Support
        userSelection = document.selection.createRange();
    }
    if (!(text = userSelection.text)) {
        text = userSelection;
    }
    return text;
}

/**
 * 选中特定范围的文本
 * 参数：
 *     textDom  [JavaScript DOM String] 当前对象
 *     startPos  [Int]  起始位置
 *     endPos  [Int]  终点位置
 */
function setSelectText(textDom, startPos, endPos) {
    var startPos = parseInt(startPos),
        endPos = parseInt(endPos),
        textLength = textDom.value.length;
    if (textLength) {
        if (!startPos) {
            startPos = 0;
        }
        if (!endPos) {
            endPos = textLength;
        }
        if (startPos > textLength) {
            startPos = textLength;
        }
        if (endPos > textLength) {
            endPos = textLength;
        }
        if (startPos < 0) {
            startPos = textLength + startPos;
        }
        if (endPos < 0) {
            endPos = textLength + endPos;
        }
        if (textDom.createTextRange) {
            // IE Support
            var range = textDom.createTextRange();
            range.moveStart("character", -textLength);
            range.moveEnd("character", -textLength);
            range.moveStart("character", startPos);
            range.moveEnd("character", endPos);
            range.select();
        } else {
            // Firefox support
            textDom.setSelectionRange(startPos, endPos);
            textDom.focus();
        }
    }
}

/**
 * 在光标后插入文本
 * 参数：
 *     textDom  [JavaScript DOM String] 当前对象
 *     value  [String]  要插入的文本
 */
function insertAfterText(textDom, value) {
    var selectRange;
    if (document.selection) {
        // IE Support
        textDom.focus();
        selectRange = document.selection.createRange();
        selectRange.text = value;
        textDom.focus();
    } else if (textDom.selectionStart || textDom.selectionStart == '0') {
        // Firefox support
        var startPos = textDom.selectionStart;
        var endPos = textDom.selectionEnd;
        var scrollTop = textDom.scrollTop;
        textDom.value = textDom.value.substring(0, startPos) + value + textDom.value.substring(endPos, textDom.value.length);
        textDom.focus();
        textDom.selectionStart = startPos + value.length;
        textDom.selectionEnd = startPos + value.length;
        textDom.scrollTop = scrollTop;
    } else {
        textDom.value += value;
        textDom.focus();
    }
}

module.exports = {
    getCursortPosition,
    setCaretPosition,
    getSelectText,
    setSelectText,
    insertAfterText
};