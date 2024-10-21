<template>
	<div style="height: 100%;">
		<index-aside v-if="'vertical' == 'vertical'" :style='{"boxShadow":"0px 0px 0px rgba(0, 0, 0, .1)","padding":"34px 0 140px","borderColor":"#666","bottom":"0","overflow":"hidden","top":"94px","borderRadius":"0","left":"0","background":"url(http://codegen.caihongy.cn/20221203/f9a249d3670c40bba3c91696d8686c19.png) no-repeat right top,url(http://codegen.caihongy.cn/20221203/1057db36d2aa4bd4b375aa0ccb752a40.png) repeat-x left top,linear-gradient(180deg, rgba(124,160,101,1) 0%, rgba(124,160,101,1) 100%),#7ca065","borderWidth":"0 0px 0 0","width":"240px","fontSize":"0px","position":"fixed","borderStyle":"solid","height":"100%","zIndex":"1001"}'></index-aside>
		<el-main :style='"vertical" == "vertical" ? {"minHeight":"100%","padding":"10px 250px 0 250px","margin":"0","background":"url(http://codegen.caihongy.cn/20221203/fb2f93dea85f41f885b444d779872985.jpg) fixed no-repeat center bottom,#f6f6f6","display":"block","backgroundSize":"100% 100%","position":"relative"} : {"minHeight":"100%","margin":"0","position":"relative"}'>
			<index-header :style='{"boxShadow":"0 0px 0px rgba(0, 0, 0, .3)","padding":"0 20px 0 0","alignItems":"center","top":"0","borderRadius":"0","left":"0","background":"url(http://codegen.caihongy.cn/20221203/008affe00a3d4084bb352eba65f5200c.png) no-repeat left top,url(http://codegen.caihongy.cn/20221203/e6448c4a6659449a886bda60983fc14b.png) no-repeat right top,url(http://codegen.caihongy.cn/20221203/70d69e278b8446b8a4a7161d9dc42210.png) repeat-x left bottom,#7ca065","display":"flex","width":"calc(100% + 0px)","position":"fixed","zIndex":"1001","height":"64px"}'></index-header>
			<index-aside v-if="'vertical' == 'horizontal'" :style='{"width":"100%","borderColor":"#efefef","borderStyle":"solid","background":"#304156","borderWidth":"0 0 1px 0","height":"auto"}'></index-aside>
			<bread-crumbs :title="title" :style='{"padding":"0","boxShadow":"0 0px 0px rgba(0,0,0,.1)","margin":"80px auto 0 auto","borderColor":"#d8e7f3 #d8e7f3 #cce2f4","borderRadius":"0","borderWidth":"0px 0 0px","background":"url(http://codegen.caihongy.cn/20221203/70d69e278b8446b8a4a7161d9dc42210.png) repeat-x left bottom,#7ca065","width":"94%","lineHeight":"44px","borderStyle":"solid","height":"44px"}' class="bread-crumbs"></bread-crumbs>
			<router-view :style='{"padding":"0px","margin":"0 auto 0 auto","overflow":"hidden","flexWrap":"wrap","background":"none","display":"block","width":"94%"}' class="router-view" style="height:auto;background: transparent;"></router-view>
		</el-main>
	</div>
</template>

<script>
	import IndexAside from '@/components/index/IndexAsideStatic'
	import IndexHeader from '@/components/index/IndexHeader'
	import menu from "@/utils/menu";
	export default {
		components: {
			IndexAside,
			IndexHeader
		},
		data() {
			return {
				menuList: [],
				role: "",
				currentIndex: -2,
				itemMenu: [],
				title: '',
			};
		},
		mounted() {
			let menus = menu.list();
			this.menuList = menus;
			this.role = this.$storage.get("role");
		},
		created() {
			this.init();
		},
		methods: {
			init(){
				this.$nextTick(()=>{
					
				})
			},
			menuHandler(menu) {
				this.$router.push({
					name: menu.tableName
				});
				this.title = menu.menu;
			},
			titleChange(index, menus) {
				this.currentIndex = index
				this.itemMenu = menus;
				console.log(menus);
			},
			homeChange(index) {
				this.itemMenu = [];
				this.title = ""
				this.currentIndex = index
				this.$router.push({
					name: 'home'
				});
			},
			centerChange(index) {
				this.itemMenu = [{
					"buttons": ["新增", "查看", "修改", "删除"],
					"menu": "修改密码",
					"tableName": "updatePassword"
				}, {
					"buttons": ["新增", "查看", "修改", "删除"],
					"menu": "个人信息",
					"tableName": "center"
				}];
				this.title = ""
				this.currentIndex = index
				this.$router.push({
					name: 'home'
				});
				
			}
		}
	};
</script>
<style lang="scss" scoped>
	a {
		text-decoration: none;
		color: #555;
	}

	a:hover {
		background: #00c292;
	}
	
	.el-main {
		padding: 0;
		display: block;
	}

	.nav-list {
		width: 100%;
		margin: 0 auto;
		text-align: left;
		margin-top: 20px;

		.nav-title {
			display: inline-block;
			font-size: 15px;
			color: #333;
			padding: 15px 25px;
			border: none;
		}

		.nav-title.active {
			color: #555;
			cursor: default;
			background-color: #fff;
		}
	}

	.nav-item {
		margin-top: 20px;
		background: #FFFFFF;
		padding: 15px 0;

		.menu {
			padding: 15px 25px;
		}
	}
	
	.detail-form-content {
	    background: transparent;
	}
</style>
