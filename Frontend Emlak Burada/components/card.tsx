import type { NextPage } from "next";
import { useMemo, type CSSProperties, useCallback } from "react";
import { useRouter } from "next/router";
import styles from "./card.module.css";

export type CardType = {
  className?: string;
  rectangle41493?: string;

  /** Style props */
  propTop?: CSSProperties["top"];
  propOpacity?: CSSProperties["opacity"];
  propLeft?: CSSProperties["left"];
};

const Card: NextPage<CardType> = ({
  className = "",
  rectangle41493,
  propTop,
  propOpacity,
  propLeft,
}) => {
  const cardStyle: CSSProperties = useMemo(() => {
    return {
      top: propTop,
      opacity: propOpacity,
      left: propLeft,
    };
  }, [propTop, propOpacity, propLeft]);

  const router = useRouter();

  const onCardContainerClick = useCallback(() => {
    router.push("/property-details");
  }, [router]);

  return (
    <div
      className={[styles.card, className].join(" ")}
      onClick={onCardContainerClick}
      style={cardStyle}
    >
      <div className={styles.cardChild} />
      <img className={styles.cardItem} alt="" src={rectangle41493} />
      <div className={styles.description}>
        <div className={styles.oceanviewRetreat}>Oceanview Retreat</div>
        <div className={styles.welcomeToOceanview}>
          Welcome to Oceanview Retreat, an exquisite beachfront property located
          in the vibrant city of Miami, Florida. Situated along the pristine
          shores of the Atlantic Ocean...
        </div>
        <div className={styles.unitParent}>
          <div className={styles.unit}>4 Unit</div>
          <img className={styles.frameIcon} alt="" src="/frame2.svg" />
        </div>
        <div className={styles.roomsParent}>
          <div className={styles.unit}>20 Rooms</div>
          <img className={styles.frameIcon} alt="" src="/frame3.svg" />
        </div>
        <img className={styles.frameIcon2} alt="" src="/frame4.svg" />
        <img className={styles.frameIcon3} alt="" src="/frame5.svg" />
      </div>
    </div>
  );
};

export default Card;
