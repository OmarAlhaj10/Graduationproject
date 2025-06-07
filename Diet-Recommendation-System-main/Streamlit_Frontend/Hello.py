import streamlit as st

st.set_page_config(
    page_title="Hello",
    page_icon="👋",
)

st.write("# Welcome to Diet Recommendation System! 👋")

st.sidebar.success("Select a recommendation app.")


st.sidebar.markdown("""
<div style='text-align: center'>
    <a href='http://localhost:5173/' target='_blank'>
        <button style='
            background-color: #4CAF50;
            color: white;
            padding: 10px 24px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        '>
            Go to React App
        </button>
    </a>
</div>
""", unsafe_allow_html=True)