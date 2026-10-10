# GUVI AI-Powered Fraud Detection System v2

Features: user transaction monitoring and alerts; admin dashboard; configurable CHECK/REVIEW thresholds; fraud case review notes; JDBC/H2 persistence; Weka RandomForest supervised ML pipeline; model retraining action.

IMPORTANT: the bundled training data is synthetic and only demonstrates the ML workflow. It does not prove real-world accuracy. Replace it with an authorized, representative labeled dataset before making performance claims.

Requirements: JDK 17+, Maven 3.9+, Tomcat 10.1+.

Build:
    mvn clean package
Deploy target/ai-fraud-detection.war to Tomcat's webapps folder, start Tomcat, then open http://localhost:8080/ai-fraud-detection/

Demo login: user/user123 and admin/admin123. Demo credentials only; not suitable for production. H2 database file is created under the current user's home folder.
Test user transactions: CUST001, 500, UPI, Greater Noida; CUST002, 75000, Unverified Wallet, high-risk.
