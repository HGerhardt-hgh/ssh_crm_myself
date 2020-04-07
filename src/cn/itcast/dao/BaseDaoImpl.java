package cn.itcast.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;


public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazzType;
	public BaseDaoImpl() {
		//1.获取当前运行对象的class
		//2.比如运行customerDao实现类，得到customerDao的实现类class
		Class clazz=this.getClass();
		
		//2.获取运行类的父类的参数化类型
		Type type=clazz.getGenericSuperclass();
		
		//3.转换成子接口ParameterizedType
		ParameterizedType ptype=(ParameterizedType) type;
		
		//4.获取实际类型参数
		//比如Map<key,value>
		Type[] types=ptype.getActualTypeArguments();
		
		//5.把type变成class
		Class clazzParameter =(Class)types[0];
		this.clazzType=clazzParameter;
	}

	//添加
	public void add(T t) {
 		this.getHibernateTemplate().save(t);
	}

	//修改
	public void update(T t) {
        this.getHibernateTemplate().update(t);		
	}

    //删除
	public void delete(T t) {
        this.getHibernateTemplate().delete(t);		
	}

	//通过id查询
	public T findById(int id) {
		
		return (T) this.getHibernateTemplate().get(clazzType, id);
	}

	//查询所有
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from "+clazzType.getSimpleName());
	}

}
