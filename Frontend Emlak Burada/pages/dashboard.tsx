import type { NextPage } from "next";
import { useCallback } from "react";
import { useRouter } from "next/router";
import styles from "./dashboard.module.css";

const Dashboard: NextPage = () => {
  const router = useRouter();

  const onPropertyContainerClick = useCallback(() => {
    router.push("/property");
  }, [router]);

  const onTenantsContainerClick = useCallback(() => {
    router.push("/packages");
  }, [router]);

  return (
    <div className={styles.dashboard}>
      <div className={styles.dashboardChild} />
      <div className={styles.dashboardItem} />
      <div className={styles.dashboardInner} />
      <div className={styles.logo}>
        <div className={styles.tmsParent}>
          <div className={styles.tms}>TMS</div>
          <img className={styles.groupIcon} alt="" src="/group.svg" />
        </div>
      </div>
      <div className={styles.dashboard1}>Dashboard</div>
      <div className={styles.totalProperty}>
        <div className={styles.totalPropertyChild} />
        <div className={styles.totalIncome}>Total Property</div>
        <div className={styles.div}>45</div>
      </div>
      <div className={styles.totalUnit}>
        <div className={styles.totalUnitChild} />
        <div className={styles.totalIncome}>Total Unit</div>
        <div className={styles.div1}>142</div>
      </div>
      <div className={styles.income}>
        <div className={styles.totalUnitChild} />
        <div className={styles.totalIncome}>Total Income</div>
        <div className={styles.div1}>$56456.00</div>
      </div>
      <div className={styles.rectangleParent}>
        <div className={styles.totalUnitChild} />
        <div className={styles.totalIncome}>Total Expense</div>
        <div className={styles.div3}>$26456.00</div>
      </div>
      <div className={styles.property} onClick={onPropertyContainerClick}>
        <div className={styles.propertyChild} />
        <div className={styles.packages}>Property</div>
      </div>
      <div className={styles.tenants} onClick={onTenantsContainerClick}>
        <div className={styles.propertyChild} />
        <div className={styles.packages}>Packages</div>
      </div>
      <div className={styles.dashboard2}>
        <div className={styles.rectangleDiv} />
        <div className={styles.dashboard3}>Dashboard</div>
      </div>
      <div className={styles.dashboardChild1} />
      <div className={styles.paymentHistory}>Payment History</div>
      <div className={styles.paymentDate}>Payment Date</div>
      <div className={styles.amount}>Amount</div>
      <div className={styles.status}>Status</div>
      <div className={styles.september2023}>September 2023</div>
      <div className={styles.div4}>$4568.00</div>
      <div className={styles.paid}>Paid</div>
      <div className={styles.october2023}>October 2023</div>
      <div className={styles.div5}>$4568.00</div>
      <div className={styles.paid1}>Paid</div>
      <div className={styles.november2023}>November 2023</div>
      <div className={styles.div6}>$4568.00</div>
      <div className={styles.paid2}>Paid</div>
      <div className={styles.seeInvoicesWrapper}>
        <div className={styles.seeInvoices}>See Invoices</div>
      </div>
      <div className={styles.dashboardChild2} />
      <div className={styles.maintenanceStatus}>Maintenance Status</div>
      <div className={styles.request001Parent}>
        <div className={styles.request001}>Request #001</div>
        <div className={styles.inProgress}>In Progress</div>
      </div>
      <div className={styles.request002Parent}>
        <div className={styles.request001}>Request #002</div>
        <div className={styles.completed}>Completed</div>
      </div>
      <div className={styles.request002Group}>
        <div className={styles.request001}>Request #002</div>
        <div className={styles.inProgress}>Pending</div>
      </div>
      <img className={styles.frameIcon} alt="" src="/frame.svg" />
      <div className={styles.ellipseDiv} />
      <div className={styles.english}>English</div>
      <div className={styles.lineParent}>
        <div className={styles.groupItem} />
        <div className={styles.groupInner} />
        <div className={styles.lineDiv} />
      </div>
      <div className={styles.profile}>
        <div className={styles.kamrul}>kamrul</div>
        <div className={styles.tid23545}>TID: 23545</div>
        <img className={styles.frameIcon1} alt="" src="/frame1.svg" />
      </div>
    </div>
  );
};

export default Dashboard;
