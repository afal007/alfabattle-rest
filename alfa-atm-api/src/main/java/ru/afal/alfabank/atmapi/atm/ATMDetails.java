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

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Статическая и редкоменяющаяся информация о банкомате
 */
@ApiModel(description = "Статическая и редкоменяющаяся информация о банкомате")
@JsonPropertyOrder({
    ATMDetails.JSON_PROPERTY_ADDRESS, ATMDetails.JSON_PROPERTY_ADDRESS_COMMENTS,
    ATMDetails.JSON_PROPERTY_AVAILABLE_PAYMENT_SYSTEMS, ATMDetails.JSON_PROPERTY_CASH_IN_CURRENCIES,
    ATMDetails.JSON_PROPERTY_CASH_OUT_CURRENCIES, ATMDetails.JSON_PROPERTY_COORDINATES, ATMDetails.JSON_PROPERTY_DEVICE_ID,
    ATMDetails.JSON_PROPERTY_NFC, ATMDetails.JSON_PROPERTY_PUBLIC_ACCESS, ATMDetails.JSON_PROPERTY_RECORD_UPDATED,
    ATMDetails.JSON_PROPERTY_SERVICES, ATMDetails.JSON_PROPERTY_SUPPORT_INFO, ATMDetails.JSON_PROPERTY_TIME_ACCESS,
    ATMDetails.JSON_PROPERTY_TIME_SHIFT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-06-29T18:11:23.447287400+07:00[Asia/Novosibirsk]")
public class ATMDetails {
    public static final String JSON_PROPERTY_ADDRESS = "address";
    public static final String JSON_PROPERTY_ADDRESS_COMMENTS = "addressComments";
    public static final String JSON_PROPERTY_AVAILABLE_PAYMENT_SYSTEMS = "availablePaymentSystems";
    public static final String JSON_PROPERTY_CASH_IN_CURRENCIES = "cashInCurrencies";
    public static final String JSON_PROPERTY_CASH_OUT_CURRENCIES = "cashOutCurrencies";
    public static final String JSON_PROPERTY_COORDINATES = "coordinates";
    public static final String JSON_PROPERTY_DEVICE_ID = "deviceId";
    public static final String JSON_PROPERTY_NFC = "nfc";
    public static final String JSON_PROPERTY_PUBLIC_ACCESS = "publicAccess";
    public static final String JSON_PROPERTY_RECORD_UPDATED = "recordUpdated";
    public static final String JSON_PROPERTY_SERVICES = "services";
    public static final String JSON_PROPERTY_SUPPORT_INFO = "supportInfo";
    public static final String JSON_PROPERTY_TIME_ACCESS = "timeAccess";
    public static final String JSON_PROPERTY_TIME_SHIFT = "timeShift";
    private PostAddress address;
    private String addressComments;
    private List<String> availablePaymentSystems = null;
    private List<String> cashInCurrencies = null;
    private List<String> cashOutCurrencies = null;
    private Coordinates coordinates;
    private Integer deviceId;
    private String nfc;
    private String publicAccess;
    private OffsetDateTime recordUpdated;
    private ATMServices services;
    private SupportInfo supportInfo;
    private ATMAccess timeAccess;
    private Integer timeShift;

    public ATMDetails address(PostAddress address) {

        this.address = address;
        return this;
    }

    /**
     * Get address
     *
     * @return address
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ADDRESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public PostAddress getAddress() {
        return address;
    }

    public void setAddress(PostAddress address) {
        this.address = address;
    }

    public ATMDetails addressComments(String addressComments) {

        this.addressComments = addressComments;
        return this;
    }

    /**
     * Вспомогательный текстовый комментарий, помогающий пользователю найти АТМ. Например, «справа от входа в торговый комплекс с улицы Кораблестроителей»
     *
     * @return addressComments
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Вспомогательный текстовый комментарий, помогающий пользователю найти АТМ. Например, «справа от входа в торговый комплекс с улицы Кораблестроителей»")
    @JsonProperty(JSON_PROPERTY_ADDRESS_COMMENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAddressComments() {
        return addressComments;
    }

    public void setAddressComments(String addressComments) {
        this.addressComments = addressComments;
    }

    public ATMDetails availablePaymentSystems(List<String> availablePaymentSystems) {

        this.availablePaymentSystems = availablePaymentSystems;
        return this;
    }

    public ATMDetails addAvailablePaymentSystemsItem(String availablePaymentSystemsItem) {
        if(this.availablePaymentSystems == null) {
            this.availablePaymentSystems = new ArrayList<>();
        }
        this.availablePaymentSystems.add(availablePaymentSystemsItem);
        return this;
    }

    /**
     * Get availablePaymentSystems
     *
     * @return availablePaymentSystems
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_AVAILABLE_PAYMENT_SYSTEMS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getAvailablePaymentSystems() {
        return availablePaymentSystems;
    }

    public void setAvailablePaymentSystems(List<String> availablePaymentSystems) {
        this.availablePaymentSystems = availablePaymentSystems;
    }

    public ATMDetails cashInCurrencies(List<String> cashInCurrencies) {

        this.cashInCurrencies = cashInCurrencies;
        return this;
    }

    public ATMDetails addCashInCurrenciesItem(String cashInCurrenciesItem) {
        if(this.cashInCurrencies == null) {
            this.cashInCurrencies = new ArrayList<>();
        }
        this.cashInCurrencies.add(cashInCurrenciesItem);
        return this;
    }

    /**
     * Список кодов валют по общероссийскому классификатору, которые АТМ поддерживает для внесения
     *
     * @return cashInCurrencies
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Список кодов валют по общероссийскому классификатору, которые АТМ поддерживает для внесения")
    @JsonProperty(JSON_PROPERTY_CASH_IN_CURRENCIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getCashInCurrencies() {
        return cashInCurrencies;
    }

    public void setCashInCurrencies(List<String> cashInCurrencies) {
        this.cashInCurrencies = cashInCurrencies;
    }

    public ATMDetails cashOutCurrencies(List<String> cashOutCurrencies) {

        this.cashOutCurrencies = cashOutCurrencies;
        return this;
    }

    public ATMDetails addCashOutCurrenciesItem(String cashOutCurrenciesItem) {
        if(this.cashOutCurrencies == null) {
            this.cashOutCurrencies = new ArrayList<>();
        }
        this.cashOutCurrencies.add(cashOutCurrenciesItem);
        return this;
    }

    /**
     * Список кодов валют по общероссийскому классификатору, которые АТМ поддерживает для выдачи
     *
     * @return cashOutCurrencies
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Список кодов валют по общероссийскому классификатору, которые АТМ поддерживает для выдачи")
    @JsonProperty(JSON_PROPERTY_CASH_OUT_CURRENCIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getCashOutCurrencies() {
        return cashOutCurrencies;
    }

    public void setCashOutCurrencies(List<String> cashOutCurrencies) {
        this.cashOutCurrencies = cashOutCurrencies;
    }

    public ATMDetails coordinates(Coordinates coordinates) {

        this.coordinates = coordinates;
        return this;
    }

    /**
     * Get coordinates
     *
     * @return coordinates
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_COORDINATES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ATMDetails deviceId(Integer deviceId) {

        this.deviceId = deviceId;
        return this;
    }

    /**
     * Номер Terminal-ID, присвоенный АТМ в процессинге Банка и передаваемый в информационном обмене между эквайрером, платежной системой и эмитентом.  Значение соответствует ISO-8583 полю 41 (Card Acceptor Terminal Identification)
     *
     * @return deviceId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Номер Terminal-ID, присвоенный АТМ в процессинге Банка и передаваемый в информационном обмене между эквайрером, платежной системой и эмитентом.  Значение соответствует ISO-8583 полю 41 (Card Acceptor Terminal Identification)")
    @JsonProperty(JSON_PROPERTY_DEVICE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public ATMDetails nfc(String nfc) {

        this.nfc = nfc;
        return this;
    }

    /**
     * Get nfc
     *
     * @return nfc
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_NFC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getNfc() {
        return nfc;
    }

    public void setNfc(String nfc) {
        this.nfc = nfc;
    }

    public ATMDetails publicAccess(String publicAccess) {

        this.publicAccess = publicAccess;
        return this;
    }

    /**
     * Доступ к АТМ. Значения: 1 &#x3D; в помещении кредитной организации в открытом доступе  2 &#x3D; в помещении кредитной организации в ограниченном доступе  3 &#x3D; вне помещения кредитной организации в открытом доступе  4 &#x3D; вне помещения кредитной организации в ограниченном доступе  (значения соответствуют правилам заполнения Ф-250 ЦБ РФ1)
     *
     * @return publicAccess
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Доступ к АТМ. Значения: 1 = в помещении кредитной организации в открытом доступе  2 = в помещении кредитной организации в ограниченном доступе  3 = вне помещения кредитной организации в открытом доступе  4 = вне помещения кредитной организации в ограниченном доступе  (значения соответствуют правилам заполнения Ф-250 ЦБ РФ1)  ")
    @JsonProperty(JSON_PROPERTY_PUBLIC_ACCESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPublicAccess() {
        return publicAccess;
    }

    public void setPublicAccess(String publicAccess) {
        this.publicAccess = publicAccess;
    }

    public ATMDetails recordUpdated(OffsetDateTime recordUpdated) {

        this.recordUpdated = recordUpdated;
        return this;
    }

    /**
     * Дата/время получения последней информации из master-системы
     *
     * @return recordUpdated
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Дата/время получения последней информации из master-системы")
    @JsonProperty(JSON_PROPERTY_RECORD_UPDATED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getRecordUpdated() {
        return recordUpdated;
    }

    public void setRecordUpdated(OffsetDateTime recordUpdated) {
        this.recordUpdated = recordUpdated;
    }

    public ATMDetails services(ATMServices services) {

        this.services = services;
        return this;
    }

    /**
     * Get services
     *
     * @return services
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_SERVICES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ATMServices getServices() {
        return services;
    }

    public void setServices(ATMServices services) {
        this.services = services;
    }

    public ATMDetails supportInfo(SupportInfo supportInfo) {

        this.supportInfo = supportInfo;
        return this;
    }

    /**
     * Get supportInfo
     *
     * @return supportInfo
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_SUPPORT_INFO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public SupportInfo getSupportInfo() {
        return supportInfo;
    }

    public void setSupportInfo(SupportInfo supportInfo) {
        this.supportInfo = supportInfo;
    }

    public ATMDetails timeAccess(ATMAccess timeAccess) {

        this.timeAccess = timeAccess;
        return this;
    }

    /**
     * Get timeAccess
     *
     * @return timeAccess
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_TIME_ACCESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ATMAccess getTimeAccess() {
        return timeAccess;
    }

    public void setTimeAccess(ATMAccess timeAccess) {
        this.timeAccess = timeAccess;
    }

    public ATMDetails timeShift(Integer timeShift) {

        this.timeShift = timeShift;
        return this;
    }

    /**
     * Сдвиг времени региона установки конкретного АТМ, относительно UTC. Например, 3
     *
     * @return timeShift
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Сдвиг времени региона установки конкретного АТМ, относительно UTC. Например, 3")
    @JsonProperty(JSON_PROPERTY_TIME_SHIFT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getTimeShift() {
        return timeShift;
    }

    public void setTimeShift(Integer timeShift) {
        this.timeShift = timeShift;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            address,
            addressComments,
            availablePaymentSystems,
            cashInCurrencies,
            cashOutCurrencies,
            coordinates,
            deviceId,
            nfc,
            publicAccess,
            recordUpdated,
            services,
            supportInfo,
            timeAccess,
            timeShift
        );
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        ATMDetails atMDetails = (ATMDetails) o;
        return Objects.equals(this.address, atMDetails.address) &&
            Objects.equals(this.addressComments, atMDetails.addressComments) &&
            Objects.equals(this.availablePaymentSystems, atMDetails.availablePaymentSystems) &&
            Objects.equals(this.cashInCurrencies, atMDetails.cashInCurrencies) &&
            Objects.equals(this.cashOutCurrencies, atMDetails.cashOutCurrencies) &&
            Objects.equals(this.coordinates, atMDetails.coordinates) && Objects.equals(this.deviceId, atMDetails.deviceId) &&
            Objects.equals(this.nfc, atMDetails.nfc) && Objects.equals(this.publicAccess, atMDetails.publicAccess) &&
            Objects.equals(this.recordUpdated, atMDetails.recordUpdated) &&
            Objects.equals(this.services, atMDetails.services) && Objects.equals(this.supportInfo, atMDetails.supportInfo) &&
            Objects.equals(this.timeAccess, atMDetails.timeAccess) && Objects.equals(this.timeShift, atMDetails.timeShift);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ATMDetails {\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    addressComments: ").append(toIndentedString(addressComments)).append("\n");
        sb.append("    availablePaymentSystems: ").append(toIndentedString(availablePaymentSystems)).append("\n");
        sb.append("    cashInCurrencies: ").append(toIndentedString(cashInCurrencies)).append("\n");
        sb.append("    cashOutCurrencies: ").append(toIndentedString(cashOutCurrencies)).append("\n");
        sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
        sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
        sb.append("    nfc: ").append(toIndentedString(nfc)).append("\n");
        sb.append("    publicAccess: ").append(toIndentedString(publicAccess)).append("\n");
        sb.append("    recordUpdated: ").append(toIndentedString(recordUpdated)).append("\n");
        sb.append("    services: ").append(toIndentedString(services)).append("\n");
        sb.append("    supportInfo: ").append(toIndentedString(supportInfo)).append("\n");
        sb.append("    timeAccess: ").append(toIndentedString(timeAccess)).append("\n");
        sb.append("    timeShift: ").append(toIndentedString(timeShift)).append("\n");
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

