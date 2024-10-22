from fpdf import FPDF

# Crea el objeto PDF
pdf = FPDF()
pdf.set_auto_page_break(auto=True, margin=15)
pdf.add_page()

# Agrega el título
pdf.set_font('Arial', 'B', 16)
pdf.cell(200, 10, txt="Test Report", ln=True, align='C')

# Agrega la imagen (captura de pantalla)
pdf.image('screenshot.png', x=10, y=30, w=180)

# Guarda el PDF
pdf.output("report.pdf")
