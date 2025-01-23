const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmfx998/",
            name: "ssmfx998",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmfx998/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于SSM的在线预约导游系统"
        } 
    }
}
export default base
