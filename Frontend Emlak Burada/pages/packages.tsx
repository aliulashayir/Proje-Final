import type { NextPage } from "next";
import { useCallback } from "react";
import { useRouter } from "next/router";
import styles from "./packages.module.css";

const Packages: NextPage = () => {
  const router = useRouter();

  const onTenantsContainerClick = useCallback(() => {
    router.push("/property");
  }, [router]);

  const onDashboardContainerClick = useCallback(() => {
    router.push("/dashboard");
  }, [router]);

  const onCardContainerClick = useCallback(() => {
    router.push("/property-details");
  }, [router]);

  return (
    <div className={styles.packages}>
      <div className={styles.packagesChild} />
      <div className={styles.packagesItem} />
      <div className={styles.packagesInner} />
      <img className={styles.logoIcon} alt="" src="/logo.svg" />
      <div className={styles.packages1}>Packages</div>
      <div className={styles.property}>
        <div className={styles.propertyChild} />
        <div className={styles.packages2}>Packages</div>
      </div>
      <div className={styles.tenants} onClick={onTenantsContainerClick}>
        <div className={styles.tenantsChild} />
        <div className={styles.property1}>Property</div>
      </div>
      <div className={styles.dashboard} onClick={onDashboardContainerClick}>
        <div className={styles.tenantsChild} />
        <div className={styles.property1}>Dashboard</div>
      </div>
      <div className={styles.ellipseDiv} />
      <div className={styles.english}>English</div>
      <div className={styles.lineParent}>
        <div className={styles.groupChild} />
        <div className={styles.groupItem} />
        <div className={styles.groupInner} />
      </div>
      <div className={styles.card} onClick={onCardContainerClick}>
        <div className={styles.cardChild} />
        <img
          className={styles.cardItem}
          alt=""
          src="/rectangle-414931@2x.png"
        />
        <div className={styles.description}>
          <div className={styles.oceanviewRetreat}>Oceanview Retreat</div>
          <div className={styles.welcomeToOceanview}>
            Welcome to Oceanview Retreat, an exquisite beachfront property
            located in the vibrant city of Miami, Florida. Situated along the
            pristine shores of the Atlantic Ocean...
          </div>
          <div className={styles.unitParent}>
            <div className={styles.unit}>4 Unit</div>
            <img className={styles.frameIcon} alt="" />
          </div>
          <div className={styles.roomsParent}>
            <div className={styles.unit}>20 Rooms</div>
            <img className={styles.frameIcon} alt="" />
          </div>
          <img className={styles.frameIcon2} alt="" />
          <img className={styles.frameIcon3} alt="" />
        </div>
      </div>
      <div className={styles.card1} onClick={onCardContainerClick}>
        <div className={styles.cardChild} />
        <img
          className={styles.cardItem}
          alt=""
          src="/rectangle-414931@2x.png"
        />
        <div className={styles.description}>
          <div className={styles.oceanviewRetreat}>Oceanview Retreat</div>
          <div className={styles.welcomeToOceanview}>
            Welcome to Oceanview Retreat, an exquisite beachfront property
            located in the vibrant city of Miami, Florida. Situated along the
            pristine shores of the Atlantic Ocean...
          </div>
          <div className={styles.unitParent}>
            <div className={styles.unit}>4 Unit</div>
            <img className={styles.frameIcon} alt="" />
          </div>
          <div className={styles.roomsParent}>
            <div className={styles.unit}>20 Rooms</div>
            <img className={styles.frameIcon} alt="" />
          </div>
          <img className={styles.frameIcon2} alt="" />
          <img className={styles.frameIcon3} alt="" />
        </div>
      </div>
      <div className={styles.card2} onClick={onCardContainerClick}>
        <div className={styles.cardChild} />
        <img
          className={styles.cardItem}
          alt=""
          src="/rectangle-414932@2x.png"
        />
        <div className={styles.description}>
          <div className={styles.oceanviewRetreat}>Oceanview Retreat</div>
          <div className={styles.welcomeToOceanview}>
            Welcome to Oceanview Retreat, an exquisite beachfront property
            located in the vibrant city of Miami, Florida. Situated along the
            pristine shores of the Atlantic Ocean...
          </div>
          <div className={styles.unitParent}>
            <div className={styles.unit}>4 Unit</div>
            <img className={styles.frameIcon} alt="" />
          </div>
          <div className={styles.roomsParent}>
            <div className={styles.unit}>20 Rooms</div>
            <img className={styles.frameIcon} alt="" />
          </div>
          <img className={styles.frameIcon2} alt="" />
          <img className={styles.frameIcon3} alt="" />
        </div>
      </div>
      <div className={styles.profile}>
        <div className={styles.kamrul}>kamrul</div>
        <div className={styles.tid23545}>TID: 23545</div>
        <img className={styles.frameIcon12} alt="" src="/frame1.svg" />
      </div>
      <div className={styles.packagesChild1} />
      <div className={styles.property2}>
        <div className={styles.propertyItem} />
        <div className={styles.buy}>BUY</div>
      </div>
      <div className={styles.tl}>{`100 TL `}</div>
      <div className={styles.ads}>10 ads</div>
      <div className={styles.packagesChild2} />
      <div className={styles.tl1}>{`250 TL `}</div>
      <div className={styles.property3}>
        <div className={styles.propertyItem} />
        <div className={styles.buy}>BUY</div>
      </div>
      <div className={styles.ads1}>25 ads</div>
      <div className={styles.packagesChild3} />
      <div className={styles.tl2}>{`500 TL `}</div>
      <div className={styles.property4}>
        <div className={styles.propertyItem} />
        <div className={styles.buy}>BUY</div>
      </div>
      <div className={styles.ads2}>500 ads</div>
    </div>
  );
};

export default Packages;
