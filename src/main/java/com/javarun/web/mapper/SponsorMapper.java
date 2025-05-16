package com.javarun.web.mapper;

import com.javarun.web.dto.SponsorDto;
import com.javarun.web.models.Sponsor;

public class SponsorMapper {
    public static Sponsor mapToSponsor(SponsorDto sponsorDto){
        return Sponsor.builder()
            .id(sponsorDto.getId())
            .passId(sponsorDto.getPassId())
            .name(sponsorDto.getName())
            .businessEntity(sponsorDto.getBusinessEntity())
            .country(sponsorDto.getCountry())
            .iban(sponsorDto.getIban())
            .build();
    }
    public static SponsorDto mapToSponsorDto(Sponsor sponsor){
        return SponsorDto.builder()
        .id(sponsor.getId())
        .passId(sponsor.getPassId())
        .name(sponsor.getName())
        .businessEntity(sponsor.getBusinessEntity())
        .country(sponsor.getCountry())
        .iban(sponsor.getIban())
        .build();
    }
}
