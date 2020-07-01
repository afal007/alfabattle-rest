/*
 * Сервис проверки статуса банкоматов
 * Сервис, возвращающий информацию о банкоматах Альфа-Банка
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: apisupport@alfabank.ru
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package ru.afal.alfabank.atmapi.atm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * JSONResponseBankATMDetails
 */
@JsonPropertyOrder({
    JSONResponseBankATMDetails.JSON_PROPERTY_DATA, JSONResponseBankATMDetails.JSON_PROPERTY_ERROR,
    JSONResponseBankATMDetails.JSON_PROPERTY_SUCCESS, JSONResponseBankATMDetails.JSON_PROPERTY_TOTAL
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-06-29T18:11:23.447287400+07:00[Asia/Novosibirsk]")
public class JSONResponseBankATMDetails {
    public static final String JSON_PROPERTY_DATA = "data";
    public static final String JSON_PROPERTY_ERROR = "error";
    public static final String JSON_PROPERTY_SUCCESS = "success";
    public static final String JSON_PROPERTY_TOTAL = "total";
    private BankATMDetails data;
    private Error error;
    private Boolean success;
    private Integer total;

    public JSONResponseBankATMDetails data(BankATMDetails data) {

        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BankATMDetails getData() {
        return data;
    }

    public void setData(BankATMDetails data) {
        this.data = data;
    }

    public JSONResponseBankATMDetails error(Error error) {

        this.error = error;
        return this;
    }

    /**
     * Get error
     *
     * @return error
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ERROR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public JSONResponseBankATMDetails success(Boolean success) {

        this.success = success;
        return this;
    }

    /**
     * Успешность выполнения запроса
     *
     * @return success
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "false", value = "Успешность выполнения запроса")
    @JsonProperty(JSON_PROPERTY_SUCCESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public JSONResponseBankATMDetails total(Integer total) {

        this.total = total;
        return this;
    }

    /**
     * Общее количество элементов в списке, если в атрибуте data передается список
     *
     * @return total
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Общее количество элементов в списке, если в атрибуте data передается список")
    @JsonProperty(JSON_PROPERTY_TOTAL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, error, success, total);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        JSONResponseBankATMDetails jsONResponseBankATMDetails = (JSONResponseBankATMDetails) o;
        return Objects.equals(this.data, jsONResponseBankATMDetails.data) &&
            Objects.equals(this.error, jsONResponseBankATMDetails.error) &&
            Objects.equals(this.success, jsONResponseBankATMDetails.success) &&
            Objects.equals(this.total, jsONResponseBankATMDetails.total);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JSONResponseBankATMDetails {\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    error: ").append(toIndentedString(error)).append("\n");
        sb.append("    success: ").append(toIndentedString(success)).append("\n");
        sb.append("    total: ").append(toIndentedString(total)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if(o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
