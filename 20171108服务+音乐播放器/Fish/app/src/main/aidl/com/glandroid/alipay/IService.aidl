// IService.aidl
package com.glandroid.alipay;

// Declare any non-default types here with import statements

interface IService {
    int callSafePay(String username, String password, float money, long timestamp);
}
