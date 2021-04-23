package DesignPattern.proxy.staticproxy;

public class TeacherDaoProxy implements ITeacherDao{
    private TeacherDao teacherDao;

    public TeacherDaoProxy(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void teach(){
        System.out.println("代理老师");
        teacherDao.teach();
        System.out.println("下课");
    }
}
