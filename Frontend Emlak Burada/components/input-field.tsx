import type { NextPage } from "next";
import { useMemo, type CSSProperties } from "react";
import styles from "./input-field.module.css";

export type InputFieldType = {
  className?: string;
  email?: string;
  kamrulgmailcom?: string;

  /** Style props */
  propTop?: CSSProperties["top"];
  propLeft?: CSSProperties["left"];
};

const InputField: NextPage<InputFieldType> = ({
  className = "",
  email,
  kamrulgmailcom,
  propTop,
  propLeft,
}) => {
  const inputFieldStyle: CSSProperties = useMemo(() => {
    return {
      top: propTop,
      left: propLeft,
    };
  }, [propTop, propLeft]);

  return (
    <div
      className={[styles.inputField, className].join(" ")}
      style={inputFieldStyle}
    >
      <div className={styles.email}>{email}</div>
      <div className={styles.inputFieldChild} />
      <div className={styles.kamrulgmailcom}>{kamrulgmailcom}</div>
    </div>
  );
};

export default InputField;
