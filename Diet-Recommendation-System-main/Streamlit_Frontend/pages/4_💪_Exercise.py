import streamlit as st
import pandas as pd
from Generate_Recommendations import Generator
from random import uniform as rnd
from ImageFinder.ImageFinder import get_images_links as find_image
from streamlit_echarts import st_echarts

st.set_page_config(page_title="Exercise", page_icon="💪", layout="wide")

# Auto-redirect using meta refresh (more reliable than JavaScript)
st.markdown(
    """
    <meta http-equiv="refresh" content="2;url=http://localhost:80/">
    <div style="text-align: center; padding: 50px;">
        <h2>Redirecting to Exercise...</h2>
        <p>You will be redirected in 2 seconds.</p>
        <p>If you are not redirected automatically, <a href="http://localhost:5173/">click here</a>.</p>
    </div>
    """,
    unsafe_allow_html=True
)

st.stop()  # Stop execution of the rest of the Streamlit app