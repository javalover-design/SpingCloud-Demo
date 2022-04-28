package com.consumer.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author lambda
 */
public class MyRandomRule extends AbstractLoadBalancerRule {
    /**
     *表示服务被调用的次数
     * 当服务调用次数达到五次，则使用下一个服务
     */
    private  int total=0;
    /**
     * 表示当前被调用的服务，一共有3个，当超过数值超过3的时候，就应当被重置为0
     */
    private  int currentIndex=0;

        @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
        public Server choose(ILoadBalancer lb, Object key) {
            if (lb == null) {
                //如果负载均衡的对象为空，则返回为空
                return null;
            } else {
                Server server = null;

                while(server == null) {
                    if (Thread.interrupted()) {
                        return null;
                    }

                    //获取所有的可用的服务列表
                    List<Server> upList = lb.getReachableServers();
                    //获取所有的服务
                    List<Server> allList = lb.getAllServers();
                    //所有服务的个数
                    int serverCount = allList.size();
                    if (serverCount == 0) {
                        return null;
                    }

                    //// 生成区间随机数
                    //int index = this.chooseRandomInt(serverCount);
                    ////从可用服务数组中取得指定下表的服务
                    //server = (Server)upList.get(index);
                    if (total<5){
                        //此处表示如果当前的服务调用次数小于5，则获取当前服务
                         server = upList.get(currentIndex);
                         //获取完成后，调用次数自增
                        total++;
                    }else {
                        //如果调用次数超过五次，则需要将调用次数重置为0
                        total=0;
                        //同时服务编号自增1
                        currentIndex++;
                        //并且如果当前服务的编号大于了可用服务的个数，说明此时可用服务已经被遍历过一遍了。
                        if (currentIndex>=upList.size()){
                            //将要被调用的服务编号重置为0。
                            currentIndex=0;
                        }
                        server=upList.get(currentIndex);
                    }

                    if (server == null) {
                        Thread.yield();
                    } else {
                        if (server.isAlive()) {
                            return server;
                        }

                        server = null;
                        Thread.yield();
                    }
                }

                return server;
            }
        }

        protected int chooseRandomInt(int serverCount) {
            return ThreadLocalRandom.current().nextInt(serverCount);
        }

        @Override
        public Server choose(Object key) {
            return this.choose(this.getLoadBalancer(), key);
        }

        @Override
        public void initWithNiwsConfig(IClientConfig clientConfig) {
        }


}
