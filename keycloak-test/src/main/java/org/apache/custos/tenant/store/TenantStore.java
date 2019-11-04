package org.apache.custos.tenant.store;

import org.apache.custos.tenant.model.Tenant;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TenantStore {

    private Map<String, Tenant> tenantMap = new ConcurrentHashMap<String, Tenant>();

    public TenantStore() {
        Tenant defaultT = new Tenant();
        defaultT.setId("default");
        this.tenantMap.put("default", defaultT);
    }

    public boolean addTenant(Tenant tenant) {
        try {
            tenantMap.put(tenant.getId(), tenant);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public Tenant getTenant(String id) {
        return tenantMap.get(id);
    }
}
