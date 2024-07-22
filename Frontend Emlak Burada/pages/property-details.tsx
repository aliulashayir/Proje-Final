import type { NextPage } from "next";
import { useCallback } from "react";
import { useRouter } from "next/router";
import Button from "../components/button";
import styles from "./property-details.module.css";

const PropertyDetails: NextPage = () => {
  const router = useRouter();

  const onTenantsContainerClick = useCallback(() => {
    router.push("/packages");
  }, [router]);

  const onDashboardContainerClick = useCallback(() => {
    router.push("/dashboard");
  }, [router]);

  const onApplyForLeasingClick = useCallback(() => {
    // Please sync "Applying for leasing" to the project
  }, []);

  return (
    <div className={styles.propertyDetails}>
      <div className={styles.propertyDetailsChild} />
      <div className={styles.propertyDetailsItem} />
      <div className={styles.propertyDetailsInner} />
      <img className={styles.logoIcon} alt="" src="/logo.svg" />
      <div className={styles.property}>Property</div>
      <div className={styles.property1}>
        <div className={styles.propertyChild} />
        <div className={styles.property2}>Property</div>
      </div>
      <div className={styles.tenants} onClick={onTenantsContainerClick}>
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
      <img
        className={styles.rectangleIcon}
        alt=""
        src="/rectangle-41488@2x.png"
      />
      <img
        className={styles.propertyDetailsChild1}
        alt=""
        src="/rectangle-41489@2x.png"
      />
      <img
        className={styles.propertyDetailsChild2}
        alt=""
        src="/rectangle-41490@2x.png"
      />
      <img
        className={styles.propertyDetailsChild3}
        alt=""
        src="/rectangle-41491@2x.png"
      />
      <div className={styles.rectangleDiv} />
      <div className={styles.oceanviewRetreat}>Oceanview Retreat</div>
      <div className={styles.propertyInformation}>Property Information</div>
      <div className={styles.welcomeToOceanview}>
        Welcome to Oceanview Retreat, an exquisite beachfront property located
        in the vibrant city of Miami, Florida. Situated along the pristine
        shores of the Atlantic Ocean, this luxurious estate offers a truly
        unparalleled coastal living experience. With breathtaking panoramic
        views of the ocean and direct access to a private white sandy beach,
        Oceanview Retreat is a haven for relaxation and rejuvenation. Immerse
        yourself in the soothing sounds of the waves and indulge in the serenity
        of the surroundings
      </div>
      <div className={styles.propertyAddressContainer}>
        <span>Property Address :</span>
        <span className={styles.span}>{`   `}</span>
        <span className={styles.oceanviewDriveMiami}>
          123 Oceanview Drive, Miami, FL 12345
        </span>
      </div>
      <div className={styles.more}>More</div>
      <div className={styles.bedrooms}>Bedrooms :</div>
      <div className={styles.div}>4</div>
      <div className={styles.bathrooms}>{`Bathrooms : `}</div>
      <div className={styles.div1}>4</div>
      <div className={styles.monthlyRent}>{`Monthly  Rent : `}</div>
      <div className={styles.div2}>$2000</div>
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

export default PropertyDetails;
