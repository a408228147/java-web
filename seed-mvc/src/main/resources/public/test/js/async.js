define(['vue','vueRouter'],function(Vue,VueRouter){
    // alert(1)
    // Vue.use(VueRouter);

    // require(["test"],function (t) {
    // });

    Vue.component('comp1',function(resolve){
        require(['comp1'],resolve);
    });
    Vue.component('comp2',function(resolve){
        require(['comp2'],resolve);
    });
    var b = new Vue({
        el:"#app",
        data:{
            currentView:'comp1',
            flag:false
        },
        methods:{
            test:function () {
                this.flag = !this.flag;
            },
            toggleView:function(){
                console.log(this.currentView);
                this.currentView = this.currentView=='comp1'?'comp2':'comp1';
            }
        }

    });
})