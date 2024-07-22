import type { NextPage } from "next";
import { useCallback } from "react";
import { useRouter } from "next/router";
import Card from "../components/card";
import Button from "../components/button";
import styles from "./property.module.css";

const Property: NextPage = () => {
  const router = useRouter();

  const onDashboardContainerClick = useCallback(() => {
    router.push("/dashboard");
  }, [router]);

  const onApplyForLeasingClick = useCallback(() => {
    // Please sync "Applying for leasing" to the project
  }, []);

  return (
    <div className={styles.property}>
      <div className={styles.propertyChild} />
      <div className={styles.propertyItem} />
      <div className={styles.propertyInner} />
      <img className={styles.logoIcon} alt="" src="/logo.svg" />
      <div className={styles.property1}>Property</div>
      <div className={styles.property2}>
        <div className={styles.rectangleDiv} />
        <div className={styles.property3}>Property</div>
      </div>
      <div className={styles.tenants}>
        <div className={styles.tenantsChild} />
        <div className={styles.packages}>Packages</div>
      </div>
      <div className={styles.dashboard} onClick={onDashboardContainerClick}>
        <div className={styles.tenantsChild} />
        <div className={styles.packages}>Dashboard</div>
      </div>
      <div className={styles.ellipseDiv} />
      <div className={styles.english}>English</div>
      <div className={styles.lineParent}>
        <div className={styles.groupChild} />
        <div className={styles.groupItem} />
        <div className={styles.groupInner} />
      </div>
      <Card rectangle41493="/rectangle-41493@2x.png" />
      <Card
        rectangle41493="/rectangle-414931@2x.png"
        propTop="706px"
        propOpacity="0"
        propLeft="340px"
      />
      <Card
        rectangle41493="/rectangle-414931@2x.png"
        propTop="235px"
        propOpacity="0"
        propLeft="860px"
      />
      <Card
        rectangle41493="/rectangle-414932@2x.png"
        propTop="701px"
        propOpacity="0"
        propLeft="860px"
      />
      <Card
        rectangle41493="/rectangle-414932@2x.png"
        propTop="235px"
        propOpacity="0"
        propLeft="1380px"
      />
      <Card
        rectangle41493="/rectangle-414932@2x.png"
        propTop="701px"
        propOpacity="0"
        propLeft="1380px"
      />
      <div className={styles.profile}>
        <div className={styles.kamrul}>kamrul</div>
        <div className={styles.tid23545}>TID: 23545</div>
        <img className={styles.frameIcon} alt="" src="/frame1.svg" />
      </div>
      <div className={styles.applyForLeasing} onClick={onApplyForLeasingClick}>
        <Button logIn="Apply" propLeft="0px" />
      </div>
    </div>
  );
};

export default Property;
