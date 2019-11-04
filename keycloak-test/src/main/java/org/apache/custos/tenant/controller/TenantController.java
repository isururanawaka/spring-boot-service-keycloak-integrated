package org.apache.custos.tenant.controller;

import org.apache.custos.tenant.model.Tenant;
import org.apache.custos.tenant.store.TenantStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class TenantController {

    @Autowired
    private TenantStore tenantStore;

    @GetMapping("/getTenant/{id}")
    public Tenant getTenant(@PathVariable String id) {
        return tenantStore.getTenant(id);
    }

    @PostMapping("/addTenant")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public boolean addTenant(@RequestBody Tenant tenant) {
        return tenantStore.addTenant(tenant);
    }
}
