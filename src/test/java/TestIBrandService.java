import com.fh.shop.api.memberuser.biz.IMemberUserService;
import com.fh.shop.api.memberuser.po.MemberUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-common.xml"})
public class TestIBrandService extends AbstractJUnit4SpringContextTests {
    @Autowired
    private IMemberUserService memberUserService;
        @Test
        public void testMemberAdd(){
            MemberUser memberUser = new MemberUser();
            memberUser.setUserName("sss");
            memberUserService.addMenberUser(memberUser);
        }
        @Test
        public void testFindMember(){
            MemberUser zhangsan = memberUserService.getUser("zhangsan");
            System.out.println(zhangsan);
        }
    }

