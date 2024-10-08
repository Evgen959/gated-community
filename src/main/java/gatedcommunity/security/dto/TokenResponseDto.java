package gatedcommunity.security.dto;

import java.util.Objects;

public class TokenResponseDto {
    private String refreshToken;
    private String accessToken;

    public TokenResponseDto(String accessToken, String refreshToken) {
        this.refreshToken = refreshToken;
        this.accessToken = accessToken;
    }

    public TokenResponseDto() {
    }

    @Override
    public String toString() {
        return String.format("Token Response: access Token: %s, refresh Token: %s", accessToken, refreshToken);
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TokenResponseDto that = (TokenResponseDto) o;
        return Objects.equals(refreshToken, that.refreshToken) && Objects.equals(accessToken, that.accessToken);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(refreshToken);
        result = 31 * result + Objects.hashCode(accessToken);
        return result;
    }
}