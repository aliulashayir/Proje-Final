import type { NextPage } from "next";
import { useMemo, type CSSProperties } from "react";
import styles from "./f-name.module.css";

export type FNameType = {
  className?: string;
  firstName?: string;
  kamrul?: string;

  /** Style props */
  propLeft?: CSSProperties["left"];
};

const FName: NextPage<FNameType> = ({
  className = "",
  firstName,
  kamrul,
  propLeft,
}) => {
  const fNameStyle: CSSProperties = useMemo(() => {
    return {
      left: propLeft,
    };
  }, [propLeft]);

  return (
    <div className={[styles.fName, className].join(" ")} style={fNameStyle}>
      <div className={styles.firstName}>{firstName}</div>
      <div className={styles.fNameChild} />
      <div className={styles.kamrul}>{kamrul}</div>
    </div>
  );
};

export default FName;
