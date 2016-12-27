# Recuriting-System


## Example
When [request home page](- "#title=openHomePage()"), then page titled [主页——思沃学院云考试系统](- "?=#title") will be loaded.
[Click 注册 button](- "#registerPage=toRegister()"), login page titled [注册/登录——思沃学院云考试系统](- "?=#registerPage.getPageTitle()") with a form will be loaded.
After [filling up the register form](- "#userCenterPage=fillRegisterForm()"), user will getting into User Center page 
[个人中心——思沃学院云考试系统](- "?=#userCenterPage.getPageTitle()") to fill up personal information,
and [click 保存 button](- "#paperListPage=fillUpInfo()") to complete the register procedure. Normally, user will be cued to [试卷列表——思沃学院云考试系统](- "?=#paperListPage.getPageTitle()")
      

To validate whether register is OK or not, we can [request the home page again](- "#title=reOpenHomePage()"), likewise,  [主页——思沃学院云考试系统](- "?=#title") will be loaded.
[Click login button](- "#loginPage=toLogin()"), login page titled [注册/登录——思沃学院云考试系统](- "?=#loginPage.getPageTitle()") with a form will be loaded.  
After [filling the login form](- "#paperListPage=fillLoginForm()"), user will successfully login into Recruiting System and see paper list page titled 
[试卷列表——思沃学院云考试系统](- "?=#paperListPage.getPageTitle()").
After [Clicking 简单的试卷](- "#consolePage=clickEasyPaper()"), new page titled [控制台——思沃学院云考试系统](- "?=#consolePage.getPageTitle()") would be loaded.  
[Click 逻辑题 button](- "#needKonwPage=clickLogicQuizzes()"), [答题需知——思沃学院云考试系统 ](- "?=#needKonwPage.getPageTitle()")page will be loaded. After reading 答题需知, user can
[start exams by click 开始 button](- "#logicPage=clickStartBtn()"). Then [逻辑题——思沃学院云考试系统](- "?=#logicPage.getPageTitle()") page will be loaded.  
The first page shown is an example page with tips 此题为例题.   






