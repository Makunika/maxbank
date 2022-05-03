package ru.pshiblo.account.business.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.pshiblo.account.business.mappers.BusinessAccountTypeMapper;
import ru.pshiblo.account.business.services.BusinessAccountTypeService;
import ru.pshiblo.account.business.web.dto.request.CreateBusinessAccountTypeDto;
import ru.pshiblo.account.business.web.dto.response.BusinessAccountTypeResponseDto;
import ru.pshiblo.common.exception.NotFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/business/type")
public class BusinessAccountTypeController {

    private final BusinessAccountTypeService service;
    private final BusinessAccountTypeMapper mapper;

    @PreAuthorize("hasAnyAuthority('ROLE_MODERATOR', 'ROLE_ADMINISTRATOR')")
    @PostMapping
    public BusinessAccountTypeResponseDto create(@Valid @RequestBody CreateBusinessAccountTypeDto request) {
        return mapper.toDTO(
                service.createType(
                        mapper.toEntity(request)
                )
        );
    }

    @GetMapping("{id}")
    public BusinessAccountTypeResponseDto getById(@PathVariable int id) {
        return mapper.toDTO(
                service.getById(id)
                        .orElseThrow(() -> new NotFoundException(id, "Type"))
        );
    }

    @GetMapping
    public List<BusinessAccountTypeResponseDto> findAll() {
        return service.getAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }


}
