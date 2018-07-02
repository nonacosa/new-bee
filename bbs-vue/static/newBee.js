/**
 * Created by Venda-GM on 2017/10/28.
 */

(function () {

    var newBee = function (selection) {
        return newBee.prototype.init(selection)
    }, _this;

    newBee.prototype = {
        init: function (selection) {
            this.$dom = $(selection);
            return _this = this;
        },
        animation: function (time, cb) {
            _this.$dom.append("<img class='has-text-centered' id='lodingAnimation' src='http://op0c7euw0.bkt.clouddn.com/newbee_loading.svg' alt='9x9 scaling square grids'>")
            setTimeout(function () {
                $('#lodingAnimation').remove();
                if (typeof cb === 'function') cb();
                return _this;
            }, time)

        },

    }
    window.newBee = newBee;

})(window);







