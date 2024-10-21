const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootmbc21/",
            name: "springbootmbc21",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootmbc21/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "“共享书角”图书借还管理系统"
        } 
    }
}
export default base
