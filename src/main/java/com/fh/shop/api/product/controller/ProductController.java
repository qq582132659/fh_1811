package com.fh.shop.api.product.controller;

import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.product.biz.IProductService;
import com.fh.shop.api.product.vo.ProductVo;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource(name = "productService")
    private IProductService productService;
    /**
     * 热销查询
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object list(String callback,Integer sellWell){
        List<ProductVo> productList = productService.findProductList(sellWell);
        ServerResponse success = ServerResponse.success(productList);
        //结合Spring提供的mappingJacksonvalue方法将我们查到的值作为一个构造函数
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(success);
        //并通过setjsonpfunction给callback赋值
        mappingJacksonValue.setJsonpFunction(callback);
        //因为将值放到了mappingJacksonValue里，所以要将这个对象返回 ，然后返回值类型定义为Object
        return mappingJacksonValue;
    }
}
