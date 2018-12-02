package com.gzy.spring.algorithm;

import java.util.Stack;

/**
 * 算法表达式
 * 中缀表达式转后缀表达式
 */
public class Calculate {


    /**
     * 中缀表达式转后缀表达式
     */
    public static String inStrToEndStr(String str){
        //存储运算符的栈
        Stack stack = new Stack();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++ ){
            char ch = str.charAt(i);

            //判断字符是否为数字，如果为数字则放入字符串中，如果为运算符则放入栈中

            if (Character.isDigit(ch)){
                sb.append(ch);
            }else {
                /**
                 * 如果入栈时，栈顶元素比入栈元素的优先级高，则栈顶元素需要先出栈，然后再入栈
                 * 运算符优先级从高到低依次如下，
                 *
                 * “(”最高，
                 * “* / ”
                 * “+ -”
                 */
                if (!stack.isEmpty()) {

                    //先获取栈顶元素
                    Object peek = stack.peek();
                    char c = peek.toString().charAt(0);

                    switch (ch) {
                        case '+':
                            if (stack.isEmpty()|| c == '(') {
                                stack.push(ch);
                            } else if (c == '*' || c == '/' ) {
                                while (!stack.isEmpty()){
                                    Object pop = stack.pop();
                                    sb.append(pop);
                                }
                                stack.push(ch);
                            }else if (c=='+' || c=='-'){
                                stack.push(ch);
                            }
                            break;
                        case '-':
                            if (stack.isEmpty()|| c=='(') {
                                stack.push(ch);
                            } else if (c == '*' || c == '/') {
                                while (!stack.isEmpty()){
                                    Object pop = stack.pop();
                                    sb.append(pop);
                                }
                                stack.push(ch);

                            }else if (c=='+' || c=='-'){
                                stack.push(ch);
                            }
                            break;
                        case '*':
                            if (stack.isEmpty()) {
                                stack.push(ch);
                            } else if (c == '(') {
                                Object pop = stack.pop();
                                sb.append(pop);
                                stack.push(ch);
                            }else if (c == '+' || c == '-'||c == '*'||c == '/'){
                                stack.push(ch);
                            }
                            break;
                        case '/':
                            if (stack.isEmpty()) {
                                stack.push(ch);
                            } else if (c == '(') {
                                Object pop = stack.pop();
                                sb.append(pop);
                                stack.push(ch);
                            }else if (c == '+' || c == '-'||c == '*'||c == '/'){
                                stack.push(ch);
                            }
                            break;
                        case '(':
                            stack.push(ch);
                            break;
                        case ')':
                            //直接出栈，直到获取"("
                            while (!stack.isEmpty()) {
                                char cc = stack.pop().toString().charAt(0);

                                if (cc == '(') {
                                    break;
                                } else {
                                    sb.append(cc);
                                }
                            }
                            break;
                        default:
                            break;
                    }

                }else {
                    stack.push(ch);
                }
            }

        }
        //将栈中运算符全部取出，
        while (!stack.isEmpty())
        sb.append(stack.pop());
        return sb.toString();

    }

    /**
     * 计算后缀表达式并获取结果
     * 规律：从左到右遍历表达式的每个数字和符号，遇到是数字就进栈，遇到是符号，
     *      就将处于栈顶两个数字出栈，进行运算，运算结果进栈，一直到最终获得结果
     * @param str
     * @return
     */
    public static Integer calculateEndStr(String str){

        Stack<Integer> stack = new Stack();

        for (int i = 0;i < str.length();i++){

            char c = str.charAt(i);

            //判断为数字的时候直接入栈
            if (Character.isDigit(c)){
                stack.push(Integer.parseInt(Character.toString(c)));
            }else{
                //从栈中取出两个数字，进行运算
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                switch (c){
                    case '+':
                        stack.push(num1+num2);
                        break;
                    case '-':
                        stack.push(num2-num1);
                        break;
                    case '*':
                        stack.push(num1*num2);
                        break;
                    case '/':
                        stack.push(num2/num1);
                        break;
                }



            }

        }

        return stack.pop();
    }


    public static void main(String[] args) {
        String inStr = "3*(2-1*2)*3+2";

        String endStr = inStrToEndStr(inStr);

        System.out.println("中缀表达式："+inStr+"\n"+"后缀表达式："+endStr);

        Integer result = calculateEndStr(endStr);

        System.out.println("\n结果："+result);


    }




}
