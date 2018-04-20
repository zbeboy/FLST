$(document).ready(function () {
    // 初始化内容与感想富文本框
    var quill = new Quill('#editor-container', {
        placeholder: '内容',
        theme: 'bubble'
    });
    quill.enable(false);
    quill.setContents(JSON.parse(init_page_param.articleContent));
});