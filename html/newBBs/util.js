/**
 * Created by Venda-GM on 2017/10/28.
 */

(function(){
    $('.modal-action').click(function(){
        var modal_id = $(this).attr('data-target');
        $('#'+modal_id).addClass('is-active')
    })
    $('.close-modal').click(function(){
        var modal_id = $(this).attr('data-target');
        $('#'+modal_id).removeClass('is-active')
    })

    //登录
    $('#login-button').click(function(){
       location.href = 'index.html?login=true';
    })



    //单机测试代码!!!
    if(window.location.href.indexOf('?login=true')) {
        $('.login-before').hide();
        $('.login-after').removeClass('is-hidden')

    }
})();