#reflect
##Class类
> 在java中，万物皆对象。  
    但基本数据类型不是对象，不过有包装类作为补充。静态的成员是属于类的，不是对象。</br>   
    类本身也是对象，是java.lang.Class类的实例对象。  
    例子：reflect: cn.dhx.reflect.ClassDemo类  
    
###Class.forName("类的全称")
> Class.forName是动态加载类。  
  编译时刻就要加载的类是静态加载类。比如用new对象，在编译时刻要加载所有可能用到的类。  
  运行时刻加载类时动态加载类。  
  例子：reflect: cn.dhx.reflect.office包下的内容

###java中的关键字都存在类类型
> 如 void,int等
###Class类的基本api操作
> 例子：reflect: cn.dhx.reflect.ClassUtil类
###方法的反射
> 例子：reflect: cn.dhx.reflect.MethodInvoke类

###泛型的本质
> 在java中集合的泛型是防止错误输入的，只在编译期起作用，绕过编译就无效了。  
  例子： cn.dhx.reflect.Generosity类