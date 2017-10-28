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
})();