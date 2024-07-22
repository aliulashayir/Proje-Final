import type { NextPage } from "next";
import { useMemo, type CSSProperties } from "react";
import styles from "./button.module.css";

export type ButtonType = {
  className?: string;
  logIn?: string;

  /** Style props */
  propLeft?: CSSProperties["left"];
};

const Button: NextPage<ButtonType> = ({ className = "", logIn, propLeft }) => {
  const buttonStyle: CSSProperties = useMemo(() => {
    return {
      left: propLeft,
    };
  }, [propLeft]);

  return (
    <div className={[styles.button, className].join(" ")} style={buttonStyle}>
      <div className={styles.logIn}>{logIn}</div>
    </div>
  );
};

export default Button;
