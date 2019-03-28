package com.example.erp01.action;

import com.example.erp01.model.Customer;
import com.example.erp01.model.User;
import com.example.erp01.service.CustomerService;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//顾客信息相关操作

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;



    @RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
    public String addCustomer(@RequestParam("customerJson")String customerJson,
                              ModelMap map){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(customerJson);
            String customerName = json.get("customerName").getAsString();
            String companyName = json.get("companyName").getAsString();
            String linkmanName = json.get("linkmanName").getAsString();
            String linkmanPhone = json.get("linkmanPhone").getAsString();
            String companyAddress = json.get("companyAddress").getAsString();
            Customer customer = new Customer(customerName,companyName,linkmanName,linkmanPhone,companyAddress);
            int res = customerService.addCustomer(customer);
            if (0 == res){
                map.addAttribute("msg","添加成功！");
            }else{
                map.addAttribute("msg","添加失败！");
            }
            return "index";
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "/deletecustomer", method = RequestMethod.POST)
    public String deleteCustomer(@RequestParam("customerID")Integer customerID,
                                 ModelMap map){
        int res = customerService.deleteCustomer(customerID);
        if(0 == res){
            map.addAttribute("msg","删除成功！");
        }else {
            map.addAttribute("msg","删除失败！");
        }
        return "index";
    }

    @RequestMapping(value = "/getallcustomer", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getAllCustomer(){
        List<Customer> customerList = customerService.getAllCustomer();
        return customerList;
    }

    @RequestMapping(value = "/getcustomerbyname", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomerByName(@RequestParam("customerName")String customerName){
        Customer customer = customerService.getCustomerByName(customerName);
        return customer;
    }

    /*
    * 测试未通过，返回结果为空
    *
    * */
    @RequestMapping(value = "/getcustomerbyid", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomerByID(@RequestParam("customerID")Integer customerID){
        System.out.println(customerID);
        Customer customer = customerService.getCustomerByID(customerID);
        if(customer == null){
            System.out.println("结果为空！");
        }
        return customer;
    }

}
