sys$org_index_html = Vue.extend({
    template: '#sys_org_index_html',

    mixins: [czyPageBar],
    data: function () {
        return {
            url: ctx + '/sys/org/selectPageByParams'
        }
    },
    methods: {
        search: function () {
            alert(123);
        },
        toEdit: function (entity) {
            alert(123);
            czy.loadComponent(ctx + '/sys/org-edit.html', '#test', function (a) {
                // debugger;
                // var a = new sys$org_edit_html();
                // var target = '#' + 'test';
                // a.$mount(target);
                debugger;
                a.open();
                a.entity = entity;
            });
        },
        del: function () {

        }
    },
    created: function () {
        //创建定时器一定要在destroyed里销毁！
        this.timer = window.setInterval(function () {
            console.log(123123)
        }, 1000)
    },
    destroyed: function () {
        //创建定时器一定要在destroyed里销毁！
        window.clearInterval(this.timer);
    }
});