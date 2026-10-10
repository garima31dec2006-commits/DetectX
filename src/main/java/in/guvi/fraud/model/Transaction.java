package in.guvi.fraud.model;
import java.math.BigDecimal;import java.time.LocalDateTime;
public class Transaction {public long id;public String customerId,paymentMethod,location,decision,explanation,reviewNote;public BigDecimal amount;public LocalDateTime createdAt;public int riskScore;public boolean reviewed;}
