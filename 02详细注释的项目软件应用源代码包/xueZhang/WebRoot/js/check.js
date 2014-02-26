function checkName(form)  
{  
    if(form.user.value=="")
    {  
        user_name.innerHTML="<font color=#FF0000>请输入用户名！</font>";
    }
    else
    	user_name.innerHTML="";
}
function checkPassword(form)
{  
    if(form.password.value=="")
    {  
        password1.innerHTML="<font color=#FF0000>请输入密码！</font>";
    }
    else
    	password1.innerHTML="";
}
function checkIdentity(form)
{
    if(form.identity.value=="")
    {  
        Identity.innerHTML="<font color=#FF0000>请输入验证码！</font>";
    }
    else
    	Identity.innerHTML="";
}

function checkUser(form)  
{  
    if(form.user_name.value=="")
    {  
        user_name1.innerHTML="<font color=#FF0000>*请输入用户名</font>";
    }
    else
    	user_name1.innerHTML="";
}
function checkmima(form)  
{  
    if(form.password.value=="")
    {  
        mima1.innerHTML="<font color=#FF0000>*请输入密码</font>";
    }
    else
    	mima1.innerHTML="";
}
function checkmima1(form)  
{  
    if(form.qrpassword.value=="")
    {  
        querenmima1.innerHTML="<font color=#FF0000>*请确认密码</font>";
    }
    else
    if(form.qrpassword.value!=form.password.value)
    	querenmima1.innerHTML="<font color=#FF0000>*密码输入不一致</font>";
    else
    	querenmima1.innerHTML="";
}
function checkRealname(form)  
{  
    if(form.realName.value=="")
    {  
        realName1.innerHTML="<font color=#FF0000>*请填写真实姓名</font>";
    }
    else
    	realName1.innerHTML="";
}
function checkEmail(form)  
{  
	var x=form.Email.value;
	i=0,j=0;
	while(i<x.length)
		{
		if(x[i]=='@')
		{
			j=j+1;
			break
		}
		else
			i=i+1;
		}
    if(form.Email.value=="")
    {  
        Email1.innerHTML="<font color=#FF0000>请填写Email</font>";
    }
    else
    if(j==0)
    	Email1.innerHTML="<font color=#FF0000>Email格式不正确</font>";
    else
    	Email1.innerHTML="";
}
function checksex(form)  
{  
    if(form.Sex.value=="")
    {  
        sex1.innerHTML="<font color=#FF0000>请选择您的性别</font>";
    }
    else
    	sex1.innerHTML="";
}
function checkdate(form)  
{  
    	date.innerHTML="";
}


function checknumber(form)  
{  
    if(form.phone.value=="")
    {  
        number11.innerHTML="<font color=#FF0000>*请填写真实的联系方式</font>";
    }
    else
    	number11.innerHTML="";
}
function checkaddress(form)  
{  
    if(form.address.value=="")
    {  
        address1.innerHTML="<font color=#FF0000>请填写您的真实地址</font>";
    }
    else
    	address1.innerHTML="";
}
function checkid(form)  
{  
    if(form.id_card.value=="")
    {  
        id.innerHTML="<font color=#FF0000>请填写您的身份证号</font>";
    }
    else
    	id.innerHTML="";
}




function checkRPCode(form)
{
	if(form.postCode.value.replace(/^\s*/,"").replace(/\s*$/,"")=="")
    {  
        insertPostcode.innerHTML="<font color=#FF0000>*请填写收货人邮编</font>";
    }
    else
    	insertPostcode.innerHTML="";
}
function checkRAddress(form)
{
	if(form.address.value.replace(/^\s*/,"").replace(/\s*$/,"")=="")
    {  
		insertAddress.innerHTML="<font color=#FF0000>*请填写收货人地址</font>";
    }
    else
    	insertAddress.innerHTML="";
}
function checkRName(form)
{
	if(form.name.value.replace(/^\s*/,"").replace(/\s*$/,"")=="")
    {  
		insertName.innerHTML="<font color=#FF0000>*请填写收货人姓名</font>";
    }
    else
    	insertName.innerHTML="";
}
function checkRPhone(form)
{
	if(form.phone.value.replace(/^\s*/,"").replace(/\s*$/,"")=="")
    {  
		insertPhone.innerHTML="<font color=#FF0000>*请填写收货人联系方式</font>";
    }
    else
    	insertPhone.innerHTML="";
}
function checkRID(form)
{
	if(form.id.value.replace(/^\s*/,"").replace(/\s*$/,"")=="")
    {  
        insertID.innerHTML="<font color=#FF0000>*请填写收货人身份证号</font>";
    }
    else
    	insertID.innerHTML="";
}
